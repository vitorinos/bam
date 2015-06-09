/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Util.Constantes;
import dados.dao.ObraDAO;
import dados.entidade.Obra;
import exception.AlertaException;
import java.util.List;

/**
 *
 * @author jacob.santana
 */
public class ObraBO {

    private static ObraBO instance;

    private ObraBO() {

    }

    public static ObraBO getInstance() {
        if (instance == null) {
            instance = new ObraBO();
        }
        return instance;
    }

    public List<Obra> consultarObraPorExemplo(Obra obra) throws Exception {
        List<Obra> obras = ObraDAO.getInstance().consultarPorExemplo(obra);
        if (obras == null || obras.isEmpty()) {
            throw new AlertaException(Constantes.MSGA2);
        }
        return obras;
    }

}
