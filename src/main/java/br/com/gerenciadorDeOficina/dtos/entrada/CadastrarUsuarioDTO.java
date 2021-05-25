package br.com.gerenciadorDeOficina.dtos.entrada;

import br.com.gerenciadorDeOficina.models.Usuario;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CadastrarUsuarioDTO {

        @NotNull(message = "{validacao.campo_obrigatorio}")
        private String nomeCompleto;

        @NotNull(message = "{validacao.campo_obrigatorio}")
        private String email;

        @NotNull(message = "{validacao.campo_obrigatorio}")
        private String senha;

        public CadastrarUsuarioDTO() {
        }

        public String getNomeCompleto() {
            return nomeCompleto;
        }

        public void setNomeCompleto(String nomeCompleto) {
            this.nomeCompleto = nomeCompleto;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }


        public Usuario converterDtoParaModelo() {
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(this.nomeCompleto);
            usuario.setEmail(this.email);
            usuario.setSenha(this.senha);
            return usuario;
        }

        public static CadastrarUsuarioDTO  converterModeloParaDTO(Usuario usuario) {
            CadastrarUsuarioDTO  dto = new CadastrarUsuarioDTO();
            dto.setNomeCompleto(usuario.getNomeCompleto());
            dto.setEmail(usuario.getEmail());

            return dto;
        }
        public static Iterable<CadastrarUsuarioDTO> converterListaDeModeloParaListaDto(Iterable<Usuario> usuarios) {
            List<CadastrarUsuarioDTO> dtos = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                dtos.add(converterModeloParaDTO(usuario));
            }
            return dtos;
        }
    }