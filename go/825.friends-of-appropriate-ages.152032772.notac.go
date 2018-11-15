func makeRequest(u, v int) bool {
    return (v <= (14 + u)/2) || (v > u) || (v > 100 && u < 100)
}
func numFriendRequests(ages []int) int {
    req := 0
    for i := 0; i < len(ages) -1 ; i++ {
        for j := i + 1; j < len(ages); j++ {
            if !makeRequest(ages[i], ages[j]) {
                req += 1
            }
            if !makeRequest(ages[j], ages[i]) {
                req += 1
            }
        }
    }
    return req
}
