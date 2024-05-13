package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.SingleConnectionBanco;
import ImportXLS.ModelOcorrencia;



public class DAOocorrenciaRepository {

    private Connection connection;

    public DAOocorrenciaRepository() {
        connection = SingleConnectionBanco.getConnection();
    }

    //Método utilizado APENAS para importar arquivos xlsx para o BD.
    //==================================================================================================================
    public ModelOcorrencia gravarExcelBanco(List<ModelOcorrencia> ocorrenciaList) throws Exception {

        try {
            for (ModelOcorrencia ocorrencia : ocorrenciaList) {

                String sql = "insert into model_ocorrencia(dia, talao, vtr, endereco, cidade, horarioin, horariofi," +
                        " kminicial, kmlocal, kmfinal, codigo, qru, tipo_ocorrencia, vitimas_vivas, vitima_fatais," +
                        " comandante, motorista, cecom, observacao)" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement statement = connection.prepareStatement(sql);

                java.sql.Date dataOcorrenciaSql = new java.sql.Date(ocorrencia.getDataOcorrencia().getTime());

                statement.setDate(1, dataOcorrenciaSql);
                statement.setInt(2, ocorrencia.getNumeroTalao());
                statement.setString(3, ocorrencia.getVtr());
                statement.setString(4, ocorrencia.getEndereco());
                statement.setString(5, ocorrencia.getCidade());
                statement.setString(6, ocorrencia.getHorarioInicial());
                statement.setString(7, ocorrencia.getHorarioFinal());
                statement.setInt(8, ocorrencia.getKmInicial());
                statement.setInt(9, ocorrencia.getKmLocal());
                statement.setInt(10, ocorrencia.getKmFinal());
                statement.setString(11, ocorrencia.getCodigo());
                statement.setString(12, ocorrencia.getQru());
                statement.setString(13, ocorrencia.getTipoOcorrencia());
                statement.setInt(14, ocorrencia.getQtdVitimasVivas());
                statement.setInt(15, ocorrencia.getQtdVitimasFatais());
                statement.setString(16, ocorrencia.getComandante());
                statement.setString(17, ocorrencia.getMotorista());
                statement.setString(18, ocorrencia.getCecom());
                statement.setString(19, ocorrencia.getObservacao());

                statement.execute();

            }
            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        }
        return null;
    }

    public List<ModelOcorrencia> buscarEnd() throws Exception {
        List<ModelOcorrencia> ocorrenciaList = new ArrayList<>();

        String sql = "select endereco, cidade from model_ocorrencia;";

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ModelOcorrencia ocorrencia = new ModelOcorrencia();

            String enderecoCompleto = resultSet.getString("endereco") + ", " + resultSet.getString("cidade");
            ocorrencia.setEndereco(enderecoCompleto);
            ocorrenciaList.add(ocorrencia);

        }
        return ocorrenciaList;
    }

    //Método utilizado APENAS para converter endereços em coordenadas e gravar no BD.
    //==================================================================================================================

    public ModelOcorrencia gravarCoordenadas(List<ModelOcorrencia> coordenadas) throws Exception {

        String sql = "update model_ocorrencia set latitude = ?, longitude = ? where id = ?";

        try {
            int id = 1;

            for (ModelOcorrencia coordenada : coordenadas) {

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDouble(1, coordenada.getLatitude());
                statement.setDouble(2, coordenada.getLongitude());
                statement.setInt(3, id);
                statement.executeUpdate();
                id++;
            }

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        return null;
    }

    //==================================================================================================================

    public ModelOcorrencia gravarOcorrencia(ModelOcorrencia ocorrencia) throws Exception {

        String sql = "insert into model_ocorrencia(dia, talao, vtr, endereco, cidade, horarioin, horariofi," +
                " kminicial, kmlocal, kmfinal, codigo, qru, tipo_ocorrencia, vitimas_vivas, vitima_fatais," +
                " comandante, motorista, cecom, observacao)" +
                "values (?, ?, UPPER(?), UPPER(?), UPPER(?), ?, ?, ?, ?, ?, UPPER(?), UPPER(?), ?, ?, ?, UPPER(?), UPPER(?), UPPER(?), UPPER(?));";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            java.util.Date dataAtual = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataAtual.getTime());

            statement.setDate(1, dataSql);
            statement.setInt(2, ocorrencia.getNumeroTalao());
            statement.setString(3, ocorrencia.getVtr());
            statement.setString(4, ocorrencia.getEndereco());
            statement.setString(5, ocorrencia.getCidade());
            statement.setString(6, ocorrencia.getHorarioInicial());
            statement.setString(7, ocorrencia.getHorarioFinal());
            statement.setInt(8, ocorrencia.getKmInicial());
            statement.setInt(9, ocorrencia.getKmLocal());
            statement.setInt(10, ocorrencia.getKmFinal());
            statement.setString(11, ocorrencia.getCodigo());
            statement.setString(12, ocorrencia.getQru());
            statement.setString(13, ocorrencia.getTipoOcorrencia());
            statement.setInt(14, ocorrencia.getQtdVitimasVivas());
            statement.setInt(15, ocorrencia.getQtdVitimasFatais());
            statement.setString(16, ocorrencia.getComandante());
            statement.setString(17, ocorrencia.getMotorista());
            statement.setString(18, ocorrencia.getCecom());
            statement.setString(19, ocorrencia.getObservacao());

            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ocorrencia;
    }

    public List<ModelOcorrencia> consultarTodasOcorrencias() throws Exception {

                List<ModelOcorrencia> retorno = new ArrayList<ModelOcorrencia>();

                String sql = "select * from model_ocorrencia order by id;";
                PreparedStatement statement = connection.prepareStatement(sql);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    ModelOcorrencia ocorrencia = new ModelOcorrencia();

                    ocorrencia.setDataOcorrencia(resultSet.getDate("dia"));
                    ocorrencia.setNumeroTalao(resultSet.getInt("talao"));
                    ocorrencia.setVtr(resultSet.getString("vtr"));
                    ocorrencia.setEndereco(resultSet.getString("endereco"));
                    ocorrencia.setCidade(resultSet.getString("cidade"));
                    ocorrencia.setQru(resultSet.getString("qru"));
                    ocorrencia.setTipoOcorrencia(resultSet.getString("tipo_ocorrencia"));
                    ocorrencia.setId(resultSet.getLong("id"));

                    retorno.add(ocorrencia);

                }

                return retorno;
    }

    public ModelOcorrencia visualizarOcorrencia(String idOcorrencia) throws Exception {

        ModelOcorrencia ocorrencia = new ModelOcorrencia();

        String sql ="select * from model_ocorrencia where id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, Long.parseLong(idOcorrencia));

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ocorrencia.setNumeroTalao(resultSet.getInt("talao"));
            ocorrencia.setEndereco(resultSet.getString("endereco"));
            ocorrencia.setCidade(resultSet.getString("cidade"));
            ocorrencia.setQru(resultSet.getString("qru"));
            ocorrencia.setTipoOcorrencia(resultSet.getString("tipo_ocorrencia"));
            ocorrencia.setHorarioInicial(resultSet.getString("horarioin"));
            ocorrencia.setHorarioFinal(resultSet.getString("horariofi"));
            ocorrencia.setKmInicial(resultSet.getInt("kminicial"));
            ocorrencia.setKmLocal(resultSet.getInt("kmlocal"));
            ocorrencia.setKmFinal(resultSet.getInt("kmfinal"));
            ocorrencia.setCodigo(resultSet.getString("codigo"));
            ocorrencia.setVtr(resultSet.getString("vtr"));
            ocorrencia.setComandante(resultSet.getString("comandante"));
            ocorrencia.setMotorista(resultSet.getString("motorista"));
            ocorrencia.setCecom(resultSet.getString("cecom"));
            ocorrencia.setObservacao(resultSet.getString("observacao"));
            ocorrencia.setQtdVitimasVivas(resultSet.getInt("vitimas_vivas"));
            ocorrencia.setQtdVitimasFatais(resultSet.getInt("vitima_fatais"));
        }
        return ocorrencia;
    }

    public void deletarOcorrencia(String idOcorrencia) throws Exception {

        String sql = "delete from model_ocorrencia where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, Integer.parseInt(idOcorrencia));

        statement.executeUpdate();
        connection.commit();
    }

    public List<ModelOcorrencia> coordenadas() throws Exception {
        List<ModelOcorrencia> coordenadaList = new ArrayList<>();

        String sql = "select latitude, longitude, qru from model_ocorrencia;";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ModelOcorrencia coordenada = new ModelOcorrencia();

            String latitude = resultSet.getString("latitude");
            String longitude = resultSet.getString("longitude");
            String qru = resultSet.getString("qru");

            coordenada.setLatitude(Double.valueOf(latitude));
            coordenada.setLongitude(Double.valueOf(longitude));
            coordenada.setQru(qru);

            coordenadaList.add(coordenada);

        }
        return coordenadaList;
    }

}
