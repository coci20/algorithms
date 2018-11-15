func area(p1, p2, p3 []int) float64 {
    return 0.5 * math.Abs(float64(p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1] - 
                          p1[1]*p2[0] - p2[1]*p3[0] - p3[1]*p1[0]))
}
func largestTriangleArea(points [][]int) float64 {
    a := 0.0
    for i := 0; i < len(points) - 2; i++{
        for j := i + 1; j < len(points) - 1; j++{
            for k := j + 1; k < len(points); k++ {
                b := area(points[i], points[j], points[k])
                if b > a {
                    a = b
                }
            } 
        }
    }
    return a
}
