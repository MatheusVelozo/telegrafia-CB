package servlets;

import Dao.DAOocorrenciaRepository;
import ImportXLS.ModelOcorrencia;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = {"/servletOcorrencia"})
public class ServletOcorrenciaController extends HttpServlet {

    private DAOocorrenciaRepository daOocorrenciaRepository = new DAOocorrenciaRepository();

    public ServletOcorrenciaController() {}

    /* Consultar e Deletar */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String acao = req.getParameter("acao");

            if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("listarOcorrencias")) {

                List<ModelOcorrencia> modelOcorrencias = daOocorrenciaRepository.consultarTodasOcorrencias();
                req.setAttribute("modelOcorrencias", modelOcorrencias);
                req.getRequestDispatcher("/main/cadastroOcorrencias.jsp").forward(req, resp);

            } else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("verDetalhesOcorrencias")) {

                String idOcorrencia = req.getParameter("idOcorrencia");

                ModelOcorrencia modelOcorrencia = daOocorrenciaRepository.visualizarOcorrencia(idOcorrencia);

                List<ModelOcorrencia> modelOcorrencias = daOocorrenciaRepository.consultarTodasOcorrencias();
                req.setAttribute("modelOcorrencias", modelOcorrencias);

                req.setAttribute("msg", "Detalhes da Ocorrência");
                RequestDispatcher redirecionar = req.getRequestDispatcher("/main/cadastroOcorrencias.jsp");
                req.setAttribute("modelOcorrencia", modelOcorrencia);
                redirecionar.forward(req, resp);

            } else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarOcorrencias")) {

                String idOcorrencia = req.getParameter("idOcorrencia");

                daOocorrenciaRepository.deletarOcorrencia(idOcorrencia);

                List<ModelOcorrencia> modelOcorrencias = daOocorrenciaRepository.consultarTodasOcorrencias();
                req.setAttribute("modelOcorrencias", modelOcorrencias);

                req.setAttribute("msg", "Deletado com sucesso!");
                RequestDispatcher redirecionar = req.getRequestDispatcher("/main/cadastroOcorrencias.jsp");
                redirecionar.forward(req, resp);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Salvar e Atualizar */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String msg = "";

            String numeroTalao = req.getParameter("nTalao");
            String vtr = req.getParameter("viatura");
            String endereco = req.getParameter("endereco");
            String cidade = req.getParameter("municipio");
            String horarioInicial = req.getParameter("horaInicial");
            String horarioFinal = req.getParameter("horaFinal");
            String kmInicial = req.getParameter("kmInicial");
            String kmLocal = req.getParameter("kmLocal");
            String kmFinal = req.getParameter("kmFinal");
            String codigo = req.getParameter("codigo");
            String qru = req.getParameter("qru");
            String tipoOcorrencia = req.getParameter("tipoOcorrencia");
            String qtdVitimasVivas = req.getParameter("vitimasVivas");
            String qtdVitimasFatais = req.getParameter("vitimasFatais");
            String comandante = req.getParameter("comandante");
            String motorista = req.getParameter("motorista");
            String cecom = req.getParameter("cecom");
            String observacao = req.getParameter("observacoes");

            ModelOcorrencia modelOcorrencia = new ModelOcorrencia();

            modelOcorrencia.setNumeroTalao(Integer.valueOf(numeroTalao));
            modelOcorrencia.setVtr(vtr);
            modelOcorrencia.setEndereco(endereco);
            modelOcorrencia.setCidade(cidade);
            modelOcorrencia.setHorarioInicial(horarioInicial);
            modelOcorrencia.setHorarioFinal(horarioFinal);
            modelOcorrencia.setKmInicial(Integer.valueOf(kmInicial));
            modelOcorrencia.setKmLocal(Integer.valueOf(kmLocal));
            modelOcorrencia.setKmFinal(Integer.valueOf(kmFinal));
            modelOcorrencia.setCodigo(codigo);
            modelOcorrencia.setQru(qru);
            modelOcorrencia.setTipoOcorrencia(tipoOcorrencia);
            modelOcorrencia.setQtdVitimasVivas(Integer.valueOf(qtdVitimasVivas));
            modelOcorrencia.setQtdVitimasFatais(Integer.valueOf(qtdVitimasFatais));
            modelOcorrencia.setComandante(comandante);
            modelOcorrencia.setMotorista(motorista);
            modelOcorrencia.setCecom(cecom);
            modelOcorrencia.setObservacao(observacao);

            modelOcorrencia = daOocorrenciaRepository.gravarOcorrencia(modelOcorrencia);

            List<ModelOcorrencia> modelOcorrencias = daOocorrenciaRepository.consultarTodasOcorrencias();
            req.setAttribute("modelOcorrencias", modelOcorrencias);

            msg = "Ocorrência gravada com sucesso!";
            req.setAttribute("msg", msg);
            req.setAttribute("modelOcorrencias", daOocorrenciaRepository.consultarTodasOcorrencias());
            RequestDispatcher dispatcher = req.getRequestDispatcher("main/cadastroOcorrencias.jsp");
            req.setAttribute("ModelOcorrencia", modelOcorrencia);
            dispatcher.forward(req, resp);


        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = req.getRequestDispatcher("main/cadastroOcorrencias.jsp");
            req.setAttribute("msg", e.getMessage());
            dispatcher.forward(req, resp);
        }

    }
}
