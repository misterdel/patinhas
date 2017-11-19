package pt.javeiros.patinhas.dao;

import pt.javeiros.patinhas.modelo.Categoria;
import pt.javeiros.patinhas.util.FabricaConexao;
import pt.javeiros.patinhas.util.UtilString;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements Serializable {

    public void salvar(Categoria categoria) {

        StringBuilder sql = new StringBuilder();

        sql.append("insert into");

        sql.append(" tb_categoria(codigo,descricao,observacao)");

        sql.append(" values (?,?,?)");

        try {
            Connection connection = FabricaConexao.conexao;

            PreparedStatement ps = connection.prepareStatement(sql.toString());

            ps.setString(1, categoria.getCodigo());

            ps.setString(2, categoria.getDescricao());

            ps.setString(3, categoria.getObservacao());

            ps.execute();

            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Problema ao salvar");

        }

    }
    public void alterar(Categoria categoria) {

        StringBuilder sql = new StringBuilder();

        sql.append("update");

        sql.append(" tb_categoria  set codigo = ? , descricao = ? , observacao = ? where");

        sql.append(" id = ?");

        try {
            Connection connection = FabricaConexao.conexao;

            PreparedStatement ps = connection.prepareStatement(sql.toString());

            ps.setString(1, categoria.getCodigo());

            ps.setString(2, categoria.getDescricao());

            ps.setString(3, categoria.getObservacao());

            ps.setLong(4, categoria.getId());

            ps.execute();

            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Problema ao salvar");

        }
    }

    public List<Categoria> consultar(Categoria categoria) {

                List<Categoria> Categorias = new ArrayList<Categoria>();

        StringBuilder sql = new StringBuilder();

        sql.append("select id, codigo, descricao, observacao from tb_categoria where ");


        if (UtilString.isNotEmptyNull(categoria.getCodigo())) {

            sql.append("codigo ilike ?");

        }

        if (UtilString.isNotEmptyNull(categoria.getDescricao())) {

            if (UtilString.isNotEmptyNull(categoria.getCodigo())) {
                sql.append(" and ");
            }

            sql.append(" descricao ilike ?");

        }

        try {
            Connection connection = FabricaConexao.conexao;

            PreparedStatement ps = connection.prepareStatement(sql.toString());

            int i = 1;
            if (UtilString.isNotEmptyNull(categoria.getCodigo())) {
                ps.setString(i++, "%" + categoria.getCodigo() + "%");
            }

            if (UtilString.isNotEmptyNull(categoria.getDescricao())) {
                ps.setString(i++, "%" + categoria.getDescricao() + "%");
            }


            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                Categoria categoraBD = new Categoria();
                categoraBD.setId(resultSet.getLong(1));
                categoraBD.setCodigo(resultSet.getString(2));
                categoraBD.setDescricao(resultSet.getString(3));
                categoraBD.setObservacao(resultSet.getString(3));

                Categorias.add(categoraBD);
            }

            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Categorias;
    }


    public void remover(Long id) {

        StringBuilder sql = new StringBuilder();

        sql.append("delete from");

        sql.append(" tb_categoria where id = ?");


        try {
            Connection connection = FabricaConexao.conexao;

            PreparedStatement ps = connection.prepareStatement(sql.toString());

            ps.setLong(1,id);

            ps.execute();

            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Problema ao salvar");

        }
    }
}
