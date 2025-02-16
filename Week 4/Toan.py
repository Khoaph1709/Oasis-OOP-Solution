def find_optimal_combination(shortfall, matrix):
    flattened = [num for row in matrix for num in row]
    flattened.sort(reverse=True) 
    n = len(flattened)
    min_total = float('inf')
    
    for i in range(n-4):
        for j in range(i+1, n-3):
            if flattened[i] + flattened[j] > min_total:
                break
            for k in range(j+1, n-2):
                current_sum = flattened[i] + flattened[j] + flattened[k]
                if current_sum > min_total:
                    break
                for l in range(k+1, n-1):
                    current_sum_4 = current_sum + flattened[l]
                    if current_sum_4 > min_total:
                        break
                    for m in range(l+1, n):
                        total = current_sum_4 + flattened[m]
                        if total >= shortfall and total < min_total:
                            min_total = total
                            if min_total == shortfall:  
                                return min_total
    return min_total if min_total != float('inf') else -1