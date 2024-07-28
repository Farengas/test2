using System.Data;
using System.Text.RegularExpressions;

namespace ASP.NET_MVC.Services
{
    public class Parser
    {
  

        public static string ValutaEspressione(string expression)
        {
            try
            {
                if (string.IsNullOrEmpty(expression))
                {
                    return "Invalid input";
                }

                expression = expression.Replace(" ", "");
                if (!EspressioneIsValid(expression))
                {
                    return "Invalid syntax or unsupported operation.";
                }

                var dataTable = new DataTable();
                var value = dataTable.Compute(expression, "");

                return value.ToString();
            }
            catch (Exception)
            {
                return "Error in evaluating expression.";
            }
        }

        private static bool EspressioneIsValid(string expression)
        {
            foreach (char c in expression)
            {
                if (!char.IsDigit(c) && "+-*/()".IndexOf(c) == -1)
                {
                    return false;
                }
            }
            return true;
        }

    }
}
