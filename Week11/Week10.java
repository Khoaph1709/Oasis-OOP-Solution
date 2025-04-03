import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {

    public static List<String> getAllFunctions(String fileContent) {
        List<String> functions = new ArrayList<>();

        // Step 1: Remove comments
        String processedContent = fileContent.replaceAll("(?s)/\\*.*?\\*/", "");
        processedContent = processedContent.replaceAll("//.*", "");

        // Step 2: Extract package and imports
        String packageName = "";
        List<String> singleImports = new ArrayList<>();
        List<String> wildcardImports = new ArrayList<>();

        Matcher packageMatcher = Pattern.compile("\\bpackage\\s+([^;]+);").matcher(processedContent);
        if (packageMatcher.find()) {
            packageName = packageMatcher.group(1).trim();
        }

        Matcher importMatcher = Pattern.compile("\\bimport\\s+(static\\s+)?([^;]+);").matcher(processedContent);
        while (importMatcher.find()) {
            boolean isStatic = importMatcher.group(1) != null;
            String importStr = importMatcher.group(2).trim();
            if (isStatic) continue;
            if (importStr.endsWith(".*")) {
                wildcardImports.add(importStr.substring(0, importStr.length() - 2));
            } else {
                singleImports.add(importStr);
            }
        }

        // Add java.lang to wildcard imports implicitly
        if (!wildcardImports.contains("java.lang")) {
            wildcardImports.add("java.lang");
        }

        // Step 3: Normalize whitespace
        processedContent = processedContent.replaceAll("\\s+", " ");

        // Step 4: Find static method declarations
        Pattern methodPattern = Pattern.compile(
                "\\bstatic\\s+([^\\s(]+(?:<[^>]+>)?(?:\\[\\])*)\\s+([a-zA-Z_$][\\w$]*)\\s*\\(");
        Matcher methodMatcher = methodPattern.matcher(processedContent);

        while (methodMatcher.find()) {
            String methodName = methodMatcher.group(2);
            String paramsStr = "";

            int start = methodMatcher.end();
            int end = findClosingParenthesis(processedContent, start);
            if (end != -1) {
                paramsStr = processedContent.substring(start, end).trim();
            }

            List<String> paramTypes = new ArrayList<>();

            if (!paramsStr.isEmpty()) {
                String[] params = paramsStr.split("\\s*,\\s*");
                for (String param : params) {
                    param = param.trim();
                    if (param.isEmpty()) continue;

                    String[] paramParts = param.split("\\s+");
                    if (paramParts.length < 2) continue;

                    StringBuilder typeBuilder = new StringBuilder();
                    for (int i = 0; i < paramParts.length - 1; i++) {
                        if (i > 0) typeBuilder.append(" ");
                        typeBuilder.append(paramParts[i]);
                    }
                    String type = typeBuilder.toString();

                    // Handle varargs: remove '...' without adding '[]'
                    type = type.replace("...", "");
                    String resolvedType = resolveFullType(type, singleImports, wildcardImports, packageName);
                    paramTypes.add(resolvedType);
                }
            }

            String signature = methodName + "(" + String.join(",", paramTypes) + ")";
            functions.add(signature);
        }

        return functions;
    }

    private static int findClosingParenthesis(String content, int start) {
        int level = 1;
        for (int i = start; i < content.length(); i++) {
            char c = content.charAt(i);
            if (c == '(') level++;
            else if (c == ')') {
                level--;
                if (level == 0) return i;
            }
        }
        return -1;
    }

    private static String resolveFullType(String type, List<String> singleImports, List<String> wildcardImports, String packageName) {
        Pattern arrayPattern = Pattern.compile("^(.*?)(\\[\\]*)$");
        Matcher arrayMatcher = arrayPattern.matcher(type);
        if (arrayMatcher.matches()) {
            String baseType = arrayMatcher.group(1);
            String arrays = arrayMatcher.group(2);
            String resolvedBase = resolveFullType(baseType, singleImports, wildcardImports, packageName);
            return resolvedBase + arrays;
        }

        int firstGeneric = type.indexOf('<');
        if (firstGeneric == -1) {
            return resolveType(type, singleImports, wildcardImports, packageName);
        }

        String rawType = type.substring(0, firstGeneric);
        String genericsPart = type.substring(firstGeneric);

        String resolvedRawType = resolveType(rawType, singleImports, wildcardImports, packageName);

        int lastGeneric = genericsPart.lastIndexOf('>');
        if (lastGeneric == -1) {
            return resolvedRawType + genericsPart;
        }

        String genericsContent = genericsPart.substring(1, lastGeneric);
        List<String> params = splitGenericParams(genericsContent);

        StringBuilder resolvedGenerics = new StringBuilder();
        for (String param : params) {
            if (resolvedGenerics.length() > 0) resolvedGenerics.append(",");
            resolvedGenerics.append(resolveFullType(param, singleImports, wildcardImports, packageName));
        }

        return resolvedRawType + "<" + resolvedGenerics + ">" + genericsPart.substring(lastGeneric + 1);
    }

    private static List<String> splitGenericParams(String genericsContent) {
        List<String> params = new ArrayList<>();
        int start = 0, level = 0;
        for (int i = 0; i < genericsContent.length(); i++) {
            char c = genericsContent.charAt(i);
            if (c == '<') level++;
            else if (c == '>') level--;
            else if (c == ',' && level == 0) {
                params.add(genericsContent.substring(start, i).trim());
                start = i + 1;
            }
        }
        params.add(genericsContent.substring(start).trim());
        return params;
    }

    private static String resolveType(String type, List<String> singleImports, List<String> wildcardImports, String packageName) {
        if (type.equals("?")) {
            return "?";
        }

        if (isPrimitive(type)) return type;
        if (type.contains(".")) return type;

        // Check single imports
        for (String imp : singleImports) {
            String[] parts = imp.split("\\.");
            if (parts[parts.length - 1].equals(type)) return imp;
        }

        // Check if it's a core Java type
        if (isJavaLangType(type)) return "java.lang." + type;

        // Check same-package
        if (!packageName.isEmpty()) {
            String samePackage = packageName + "." + type;
            return samePackage;
        }

        // Check wildcard imports
        for (String wildcard : wildcardImports) {
            String fqn = wildcard + "." + type;
            return fqn;
        }

        // Return type as-is if not resolved (assumed to be a type parameter)
        return type;
    }

    private static boolean isPrimitive(String type) {
        return type.matches("^(byte|short|int|long|float|double|boolean|char|void)$");
    }

    private static boolean isJavaLangType(String type) {
        return type.matches("^(Object|String|Integer|Long|Double|Float|Boolean|Byte|Character|Short|Void|Class|Package|Enum|Exception|Error|Throwable|Thread|Runnable|System|Math|Runtime|Process|StringBuffer|StringBuilder)$");
    }
}