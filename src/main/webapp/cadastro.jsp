<%-- 
    Document   : cadastro
    Created on : 01/10/2017, 14:05:44
    Author     : Reginaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>
    <link href="css/configuracao.css" rel="stylesheet" type="text/css">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>

  <body>
    <div class="navbar-fixed">
      <nav>
        <div class="nav-wrapper cyan darken-4">
          <a href="login.jsp" class="brand-logo"><i class="material-icons">arrow_back</i>Cadastro</a>
        </div>
      </nav>
    </div>

    <div class="container">
      <div class="row">
        <form id="formCliente" class="form-horizontal templatemo-login-form-2" enctype="multipart/form-data" role="form" action="CadastrarUsuario" method="post">
            
           <div class="templatemo-one-signin col-md-12">
                <div class="imgPerfil">
                    <img src="${usuario.foto}" alt="" id="imagem" class="imagem-perfil">
                </div>
                <br>

                <div class="adicionar-foto">
                    <input type="file" required onchange="readURL(this)" accept="image/*" class="foto" name="foto" >
                </div>

            </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="nome" type="text" name="nome" value="" required>
              <label for="nome">Nome</label>
            </div>
            <div class="input-field col s6">
              <input id="email" type="text" name="email" value="" required>
              <label for="email">E-mail</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="senha" type="password" name="senha" value="" required>
              <label for="senha">Senha</label>
            </div>
            <div class="input-field col s6">
              <input id="nascimento" name="nascimento" type="text" class="datepicker" required>
              <label for="nascimento">Data de nascimento</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <input id="telefone" type="tel" name="telefone" value="">
              <label for="telefone">Telefone</label>
            </div>
            <div class="input-field col s6">
              <select name="sexo">
                <option value="masculino">Masculino</option>
                <option value="feminino">Feminino</option>
              </select>
              <label>Sexo</label>
            </div>
          </div>
          <div class="row right-align">
            <input id="btCadastro" class="btn" type="submit" name="" value="Cadastro">
          </div>
        </form>
      </div>
    </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="js/plugin.js"></script>
  </body>
</html>
<script>
                                    function atualizafoto() {
                                        var fotoDigitada = document.forms["formCliente"]["clifoto"].value;
                                        document.forms["formCliente"]["mostraFoto"].src = fotoDigitada;
                                    }
                                    window.onload = function () {
                                        document.forms["formCliente"]["clifoto"].oninput = atualizafoto;
                                    };
                                </script>
                                <script>
                                    function readURL(input) {
                                        if (input.files && input.files[0]) {
                                            var reader = new FileReader();

                                            reader.onload = function (e) {
                                                var imagem = document.getElementById('imagem');
                                                imagem.src = e.target.result;
                                            };

                                            reader.readAsDataURL(input.files[0]);
                                        }
                                    }
                                    window.addEventListener('load', load);
                                </script>
