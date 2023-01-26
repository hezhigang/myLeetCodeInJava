/**
54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/
*/

namespace PeterHe.LeetCode
{
    class SpiralMaxtrix
    {
        public static IList<int> SpiralOrder(int[,] matrix)
        {
            IList<int> list = new List<int>();
            int height = matrix.GetLength(0);
            int width = height == 0 ? 0 : matrix.GetLength(1);
            int size = height * width;

            int[] dirX = { 0, 1, 0, -1 };
            int[] dirY = { 1, 0, -1, 0 };

            int x = 0, y = -1, dir = 0;
            for (int step, total = 0; total < size; total += step)
            {
                if (dir == 0 || dir == 2)
                {
                    step = width;
                    height--;
                }
                else
                {
                    step = height;
                    width--;
                }
                for (int i = step; i > 0; i--)
                {
                    x += dirX[dir];
                    y += dirY[dir];
                    list.Add(matrix[x, y]);
                }
                dir = ++dir % 4;
            }

            return list;
        }
    }
}