using PeterHe.LeetCode;

namespace Console2
{
    class Program
    {
        static void Main(string[] args)
        {
            // 54. Spiral Matrix
            // https://leetcode.com/problems/spiral-matrix/
            // int[,] array2D = new int[,] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

            int[,] array2D = new int[,] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

            System.Console.WriteLine("Rank = " + array2D.Rank);

            System.Console.WriteLine("rows = " + array2D.GetLength(0));

            System.Console.WriteLine("cols = " + array2D.GetLength(1));

            for (int i = 0; i < array2D.GetLength(0); i++)
            {
                for (int j = 0; j < array2D.GetLength(1); j++)
                {
                    System.Console.Write(array2D[i, j] + " ");
                }
                System.Console.WriteLine();
            }

            IList<int> list = SpiralMaxtrix.SpiralOrder(array2D);

            foreach (int i in list)
            {
                System.Console.Write(i + " ");
            }
            System.Console.WriteLine();
        }
    }
}