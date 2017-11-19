package pt.javeiros.patinhas.service;

import pt.javeiros.patinhas.dao.CategoriaDAO;
import pt.javeiros.patinhas.execptions.BusinessExecption;
import pt.javeiros.patinhas.modelo.Categoria;
import pt.javeiros.patinhas.util.UtilString;

import java.io.Serializable;
import java.util.List;

public class CategoriaService implements Serializable{

    public void salvar(Categoria categoria) {

        CategoriaDAO dao = new CategoriaDAO();

        dao.salvar(categoria);

    }

    public void alterar(Categoria categoria) {

        CategoriaDAO dao = new CategoriaDAO();

        dao.alterar(categoria);
    }

    public List<Categoria> consultar(Categoria categoria) throws BusinessExecption {

        if(UtilString.isEmpty(categoria.getCodigo()) && UtilString.isEmpty(categoria.getDescricao())){

            throw new BusinessExecption("Necessário informar pelomenos um item para a consulta");
        }

        CategoriaDAO dao = new CategoriaDAO();

        return dao.consultar(categoria);
    }

    public void remover(Long id) {

        CategoriaDAO dao = new CategoriaDAO();

        dao.remover(id);
    }
}
