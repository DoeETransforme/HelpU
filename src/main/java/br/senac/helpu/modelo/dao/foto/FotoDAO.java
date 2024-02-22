package br.senac.helpu.modelo.dao.foto;

import java.util.List;

import br.senac.helpu.modelo.entidade.foto.Foto;
import br.senac.helpu.modelo.entidade.usuario.Usuario;

public interface FotoDAO {

    void inserirFoto(Foto foto);
    void deletarFoto(Foto foto);
    void atualizarFoto(Foto foto);

    Foto recuperarFotoId(Long id);
    Foto recuperarFotoUsuario(Usuario usuario);
    List<Foto> recuperarFotos();

}
