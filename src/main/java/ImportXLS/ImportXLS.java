package ImportXLS;

import Dao.DAOocorrenciaRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImportXLS {

    public List<ModelOcorrencia> ocorrencias = new ArrayList<ModelOcorrencia>();

    public static void main(String[] args) {

        ImportXLS importXLS = new ImportXLS();

        try {
            FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Matheus Velozo\\eclipse-workspace\\TelegrafiaCB\\src\\main\\java\\ImportXLS\\controleDeOcorrencias.xlsx"));


            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(entrada); //Prepara a entrada do arquivo Excel para leitura.
            XSSFSheet planilha = xssfWorkbook.getSheetAt(0); //Pega a primeira planilha do arquivo.

            Iterator<Row> linhaIterator = planilha.iterator();

            List<ModelOcorrencia> ocorrencias = importXLS.ocorrencias;

                while (linhaIterator.hasNext()) { //Enquanto tiver linha no arquvio excel.
                    Row linha = linhaIterator.next(); //Dados da linha.
                    Iterator<Cell> celula = linha.iterator();

                    ModelOcorrencia ocorrencia = new ModelOcorrencia();
                    boolean linhaVazia = true;

                    while (celula.hasNext()) { //percorrer as celulas.
                        Cell cell = celula.next();

                        if (cell != null && cell.getCellType() != CellType.BLANK && !cell.toString().isEmpty()) {
                            linhaVazia = false;
                            switch (cell.getColumnIndex()) {
                                case 0:
                                    ocorrencia.setDataOcorrencia(cell.getDateCellValue());
                                    break;
                                case 1:
                                    ocorrencia.setNumeroTalao(Double.valueOf(cell.getNumericCellValue()).intValue());
                                    break;
                                case 2:
                                    ocorrencia.setVtr(cell.getStringCellValue());
                                    break;
                                case 3:
                                    ocorrencia.setEndereco(cell.getStringCellValue());
                                    break;
                                case 4:
                                    ocorrencia.setCidade(cell.getStringCellValue());
                                    break;
                                case 5:
                                    LocalDateTime dateTime = cell.getLocalDateTimeCellValue();
                                    if (dateTime != null) {
                                        LocalTime horario = dateTime.toLocalTime();
                                        String horarioStr = horario.toString();
                                        ocorrencia.setHorarioInicial(horarioStr);
                                    } else {
                                        ocorrencia.setHorarioInicial(null);
                                    }
                                    break;
                                case 6:
                                    LocalDateTime dateTimeF = cell.getLocalDateTimeCellValue();
                                    if (dateTimeF != null) {
                                        LocalTime horarioF = dateTimeF.toLocalTime();
                                        String horarioFStr = horarioF.toString();
                                        ocorrencia.setHorarioFinal(horarioFStr);
                                    } else {
                                        ocorrencia.setHorarioFinal(null);
                                    }
                                    break;
                                case 7:
                                        ocorrencia.setKmInicial(Double.valueOf(cell.getNumericCellValue()).intValue());
                                    break;
                                case 8:
                                        ocorrencia.setKmLocal(Double.valueOf(cell.getNumericCellValue()).intValue());
                                    break;
                                case 9:
                                    ocorrencia.setKmFinal(Double.valueOf(cell.getNumericCellValue()).intValue());
                                    break;
                                case 10:
                                    ocorrencia.setCodigo(cell.getStringCellValue());
                                    break;
                                case 11:
                                    ocorrencia.setQru(cell.getStringCellValue());
                                    break;
                                case 12:
                                    ocorrencia.setTipoOcorrencia(cell.getStringCellValue());
                                    break;
                                case 13:
                                    ocorrencia.setQtdVitimasVivas(Double.valueOf(cell.getNumericCellValue()).intValue());
                                    break;
                                case 14:
                                    ocorrencia.setQtdVitimasFatais(Double.valueOf(cell.getNumericCellValue()).intValue());
                                    break;
                                case 15:
                                    ocorrencia.setComandante(cell.getStringCellValue());
                                    break;
                                case 16:
                                    ocorrencia.setMotorista(cell.getStringCellValue());
                                    break;
                                case 17:
                                    ocorrencia.setCecom(cell.getStringCellValue());
                                    break;
                                case 18:
                                    ocorrencia.setObservacao(cell.getStringCellValue());
                                    break;
                            }
                        }
                    }
                    if (!linhaVazia) {
                        ocorrencias.add(ocorrencia);
                    }
                }
            entrada.close();

                /* visualizar saída no console do arquivo importado.

                for (ModelOcorrencia ocorrencia : ocorrencias) {
                    System.out.println(ocorrencia);
                }

                 */

            DAOocorrenciaRepository daOocorrenciaRepository = new DAOocorrenciaRepository();
            try {
                daOocorrenciaRepository.gravarExcelBanco(ocorrencias);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
