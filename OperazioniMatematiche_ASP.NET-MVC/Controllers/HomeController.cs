using ASP.NET_MVC.Models;
using ASP.NET_MVC.Services;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace ASP.NET_MVC.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View(new OperazioneMatematicaVM());
        }

        [HttpPost]
        public IActionResult Valuta(OperazioneMatematicaVM model)
        {
            try
            {
                double numero;
                var risultato = Parser.ValutaEspressione(model.Input);
                if(!double.TryParse(risultato, out numero)) { 
                    model.Errore = risultato;
                    model.Risultato = null;
                } else {
                    model.Risultato = risultato;
                    model.Errore = null;
                }
            }
            catch (Exception ex)
            {
                model.Risultato = null;
                model.Errore = ex.Message;
            }
            return View("Index", model);
        }



        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
