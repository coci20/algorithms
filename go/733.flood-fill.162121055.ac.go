func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
    // negative conditions
    if sr >= len(image) || sc >= len(image[0]) || sr < 0 || sc < 0 {
        return image
    }
    if image[sr][sc] == newColor {
        return image
    }
    oldColor := image[sr][sc]
    image[sr][sc] = newColor
    for i := sr-1; i <= sr + 1 && i < len(image); i++ {
        if i < 0 || i == sr {
            continue
        }
        if image[i][sc] == oldColor {
            image = floodFill(image, i, sc, newColor)
        }
    }
    for i := sc-1; i <= sc + 1 && i < len(image[0]); i++ {
        if i < 0 || i == sc {
            continue
        }
        if image[sr][i] == oldColor {
            image = floodFill(image, sr, i, newColor)
        }
    }
    return image
}
