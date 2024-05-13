package servlets;

import Dao.DAOocorrenciaRepository;
import ImportXLS.ModelOcorrencia;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/servletMapa"})
public class ServletMapaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DAOocorrenciaRepository daOocorrenciaRepository  = new DAOocorrenciaRepository();

    public ServletMapaController() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String acao = req.getParameter("acao");

             if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("coordenadas")) {

                List<ModelOcorrencia> modelOcorrencias = daOocorrenciaRepository.coordenadas();
                List<Object[]> coordenadasArray = new ArrayList<>();

                for (ModelOcorrencia modelOcorrencia : modelOcorrencias) {
                    Object[] coordenada = {modelOcorrencia.getLatitude(), modelOcorrencia.getLongitude(), modelOcorrencia.getQru()};
                    coordenadasArray.add(coordenada);
                }

                String jsonCoordenadas = new Gson().toJson(coordenadasArray);
                req.setAttribute("coordenadasJSON", jsonCoordenadas);
                req.getRequestDispatcher("/main/mapaOcorrencias.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
