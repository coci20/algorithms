func getDistance(seats []int, index int) int {
    dist1 := 1
    for i := index-1; i >= 0; i--{
        if seats[i] == 0 {
            dist1++
        } else {
            break
        }
    }
    dist2 := 1
    for i := index+1; i < len(seats); i++{
        if seats[i] == 0 {
            dist2++
        } else {
            break
        }
    }
    if index == len(seats)-1{
        if dist1 == 1{
            return 1
        } else {
            return dist1
        }
    }
    if index == 0{
        if dist2 == 1 {
            return 1
        } else {
            return dist2
        }
    }
    if dist1 == 1 || dist2 == 1 {
        return 1
    }
    if dist1 > dist2 {
        return dist2
    }
    return dist1
}
func maxDistToClosest(seats []int) int {
    m := make(map[int]int)
    for i := 0; i < len(seats); i++{
        if seats[i] == 0 {
            m[i] = getDistance(seats, i)
        }
    }
    max := 0
    for _, v := range m {
        if v > max{
            max = v
        }
    }
    return max
}
