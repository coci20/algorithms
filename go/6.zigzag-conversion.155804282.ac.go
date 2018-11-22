import "fmt"
type MyPoint struct {
	x, y int
}

func createPoints(l, n int) ([]MyPoint, int) {
	count := 0
	var points []MyPoint
	j := 0
	i := 0
	for count < l {
		for i = 0; i < n; i++ {
			var p MyPoint
			p.x = i
			p.y = j
			points = append(points, p)
			count++
			if count == l {
				return points, j
			}
		}
        j++
		for i = n - 2; i > 0; i-- {
			var p MyPoint
			p.x = i
			p.y = j
			j++
			points = append(points, p)
			count++
			if count == l {
				return points, j
			}
		}
	}
	return points, j
}

func convert(s string, numRows int) string {
    points, col := createPoints(len(s), numRows)
    mat := make([][]rune, numRows)
    for i := range mat{
        mat[i] = make([]rune, col+1)
    }
    runes := []rune(s)
    for i := 0; i < len(mat); i++{
        for j := 0; j < len(mat[i]); j++{
            mat[i][j] = '0'
        }
    }
    for i := 0; i < len(points); i++{
        mat[points[i].x][points[i].y] = runes[i]
    }
    str := ""
    for i := 0; i < len(mat); i++{
        for j := 0; j < len(mat[i]); j++{
            if mat[i][j] != '0' {
                str += string(mat[i][j])    
            }
        }
    }
    return str
}
