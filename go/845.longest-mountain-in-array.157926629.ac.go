func makeMountain(index int, input []int) int {
	size1 := 0
    size2 := 0
    left := index - 1
	i := index
	for left >= 0 && input[left] < input[i] {
		left--
		i--
		size1++
	}
	right := index + 1
	i = index
	for right < len(input) && input[i] > input[right] {
		right++
		i++
		size2++
	}
    size := 0
    if size1 > 0 && size2 > 0 {
        size = size1 + size2 + 1
    }
	return size
}
func longestMountain(input []int) int {
    m := make(map[int]int)
	for i := 0; i < len(input); i++ {
		m[i] = makeMountain(i, input)
	}
	r := m[0]
	for _, v := range m {
		if r < v {
			r = v
		}
	}
    return r
}
