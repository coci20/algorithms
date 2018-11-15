func minDist(pos int, vals []int) int {
    if pos < vals[0]{
        return vals[0]-pos
    }
    if pos > vals[len(vals)-1]{
        return pos-vals[len(vals)-1]
    }
    for i := 0; i+1 < len(vals); i++{
        if pos > vals[i] && pos < vals[i+1] {
            if pos-vals[i] > vals[i+1]-pos {
                return vals[i+1]-pos
            } else {
                return pos-vals[i]
            }
        }
    }
    return -1
}
func findRadius(houses []int, heaters []int) int {
    m := make(map[int]bool)
    for _,v := range heaters{
        m[v] = true
    }
    dist := make([]int, len(houses))
    sort.Ints(heaters)
    for i := 0; i < len(houses); i++{
        if m[houses[i]] {
            dist[i] = 0
        } else {
            dist[i] = minDist(houses[i], heaters)
        }
    }
    max := dist[0]
    for _, v := range dist{
        if max < v {
            max = v
        }
    }
    return max
}
