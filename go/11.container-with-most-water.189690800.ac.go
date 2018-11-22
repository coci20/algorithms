func getArea(h, max int, values []int) int {
    for i, v := range values{
        height := h
        if v < h{
            height = v
        }
        area := i*height
        if area > max{
            max = area
        }
    }
    return max
}
func maxArea(height []int) int {
    max := 0
    for i := 0; i < len(height); i++{
        max = getArea(height[i], max, height[i:])
    }
    return max
}
