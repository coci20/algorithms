func dfs(m map[int][]int, visited []bool, v int) []bool {
    visited[v] = true
    for _, r := range m[v]{
        if !visited[r] && r != v {
            visited = dfs(m, visited, r)
        }
    }
    return visited
}
func canVisitAllRooms(rooms [][]int) bool {
    m := make(map[int][]int)
    for i := 0; i < len(rooms); i++{
        m[i] = append(m[i], rooms[i]...)
    }
    numRooms := len(rooms)
	visited := make([]bool, numRooms)
    visited = dfs(m, visited, 0)
    for _, v := range visited{
        if v == false {
            return false
        }
    }
    return true
}
