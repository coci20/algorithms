func dontOverlap(rec1 , rec2 []int) bool {
    return rec2[0] >= rec1[2] || rec2[3] <= rec1[1] || rec2[2] <= rec1[0] || rec2[1] >= rec1[3]
}
func isRectangleOverlap(rec1 []int, rec2 []int) bool {
    if dontOverlap(rec1, rec2) {
        return false
    }
    return true
}
