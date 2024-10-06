import com.angelodev.screenmatch.calculos.CalculadoraDeTiempo;
import com.angelodev.screenmatch.calculos.FiltroRecomendacion;
import com.angelodev.screenmatch.modelos.Episodio;
import com.angelodev.screenmatch.modelos.Pelicula;
import com.angelodev.screenmatch.modelos.Serie;
public class Principal {
    public static void main(String[] args){
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(190);
        miPelicula.setIncluidoEnElPlan(true);
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println("******************");
        miPelicula.muestraFichaTecnica();
        System.out.println("---");
        System.out.println("El total de evaluaciones es: " + miPelicula.getTotalDeLasEvaluaciones());
        System.out.println("La media es: " + miPelicula.calculaMedia());
        System.out.println("******************");

        Serie casaDragon = new Serie();
        casaDragon.setNombre("La casa del dragon");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println("---");
        System.out.println("Duración de toda la serie en minutos: " + casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.setNombre("Avengers");
        otraPelicula.setFechaDeLanzamiento(2012);
        otraPelicula.setDuracionEnMinutos(180);
        System.out.println("\n********************************");
        otraPelicula.muestraFichaTecnica();
        System.out.println("********************************\n");

        System.out.println("*****Calculadora de maratones: *****");
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus titulos favoritos " + calculadora.getTiempoTotal() + " minutos.");
        System.out.println("********************");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumeroEpisodio(1);
        episodio.setNombre("La casa taegueris");
        episodio.setSerie(casaDragon);
        episodio.setTotalDeVisualizaciones(101);
        filtroRecomendacion.filtra(episodio);

    }
}
