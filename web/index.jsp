<!--<%-- 
    Document   : index
    Created on : 18/12/2019, 12:24:41
    Author     : e.andre.germano
--%>-->

<!--<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seja bem-vindo</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


        <div class="cotn_principal">
            <div class="cont_centrar">

                <div class="cont_login">
                    <div class="cont_info_log_sign_up">
                        <div class="col_md_login">
                            <div class="cont_ba_opcitiy">

                                <h2>LOGIN</h2>  
                                <p></p> 
                                <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
                            </div>
                        </div>
                        <div class="col_md_sign_up">
                            <div class="cont_ba_opcitiy">
                                <h2>SIGN UP</h2>


                                <p></p>

                                <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
                            </div>
                        </div>
                    </div>


                    <div class="cont_back_info">
                        <div class="cont_img_back_grey">
                            <img src="https://www.gtagangwars.de/suite/images/styleLogo-6bd77433ddf78bd8477ea7306e804f677bc925d0.png" alt="" />
                        </div>

                    </div>
                    <div class="cont_forms" >
                        <div class="cont_img_back_">
                            <img src="https://www.gtagangwars.de/suite/images/styleLogo-6bd77433ddf78bd8477ea7306e804f677bc925d0.png" alt="" />
                        </div>
                        <div class="cont_form_login">
                            <a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons"></i></a>
                            <h2>LOGIN</h2>
                            <input type="text" placeholder="Email" name="txtEmail"/>
                            <input type="password" placeholder="Senha" name="txtSenha"/>
                            <input type="submit" value="Entrar" name="acao" onclick="cambiar_login()">                            
                        </div>

                        <div class="cont_form_sign_up">
                            <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons"></i></a>
<!--                            <h2>SIGN UP</h2>-->
                            <input type="text" style="height:30px;" placeholder="Nome" />
                            <input type="text" style="height:30px;" placeholder="Sobrenome" />
                            <input type="text" style="height:30px;" placeholder="Telefone" />
                            
                            <h8>Endereço de cobrança</h8>
                            <input type="text" style="height:30px;" placeholder="Endereço e número" />
                            <input type="text" style="height:30px;" placeholder="Cep" />
                            <input type="text" style="height:30px;" placeholder="Cidade" />
                            <input type="text" style="height:30px;" placeholder="Estado" />
                            
                            <h8>Endereço de entrega</h8>
                            <input type="text" style="height:30px;" placeholder="Endereço e número" />
                            <input type="text" style="height:30px;" placeholder="Cep" />
                            <input type="text" style="height:30px;" placeholder="Cidade" />
                            <input type="text" style="height:30px;" placeholder="Estado" />
                            <hr />
                            <input type="text" style="height:30px;" placeholder="Email" />
                            <input type="password" style="height:30px;" placeholder="Senha" />
                            <input type="password" style="height:30px;" placeholder="Confirme a senha" />
                            <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>

                        </div>

                    </div>

                </div>
            </div>
        </div>
        <script>
            /* ------------------------------------ Click on login and Sign Up to  changue and view the effect
             ---------------------------------------
             */

            function cambiar_login() {
                document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
                document.querySelector('.cont_form_login').style.display = "block";
                document.querySelector('.cont_form_sign_up').style.opacity = "0";

                setTimeout(function () {
                    document.querySelector('.cont_form_login').style.opacity = "1";
                }, 400);

                setTimeout(function () {
                    document.querySelector('.cont_form_sign_up').style.display = "none";
                }, 200);
            }

            function cambiar_sign_up(at) {
                document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
                document.querySelector('.cont_form_sign_up').style.display = "block";
                document.querySelector('.cont_form_login').style.opacity = "0";

                setTimeout(function () {
                    document.querySelector('.cont_form_sign_up').style.opacity = "1";
                }, 100);

                setTimeout(function () {
                    document.querySelector('.cont_form_login').style.display = "none";
                }, 400);


            }



            function ocultar_login_sign_up() {

                document.querySelector('.cont_forms').className = "cont_forms";
                document.querySelector('.cont_form_sign_up').style.opacity = "0";
                document.querySelector('.cont_form_login').style.opacity = "0";

                setTimeout(function () {
                    document.querySelector('.cont_form_sign_up').style.display = "none";
                    document.querySelector('.cont_form_login').style.display = "none";
                }, 500);

            }




        </script>
    </body>
</html>


