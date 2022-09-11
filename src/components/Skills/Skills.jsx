import React from 'react'
import '../../css/styles.css'

export default function Skills() {

  return (
    
    <>
      <h2>Soft-Skills</h2>

      <p>Soft skills são habilidades comportamentais relacionadas a maneira como o profissional lida com o outro e consigo mesmo em diferentes situações, essenciais para o ambiente de trabalho.
      Assim sendo, o candidato fica a vontade entre escrever sobre as habilidades comportamentais que ele tem conhecimento, ou a realização de um teste no site de “16Personalities” no link abaixo.
      Com base no resultado encontrado devolvemos as soft-skill correspondentes, e assim o usuário poderá preencher o formulário adequadamente. 
      Lembrando que, se o usuário desejar ele pode refazer o teste futuramente e atualizar as suas informações.
      </p>

      <p>Faça um testes de suas Skills aqui.</p>

          <div>
              <ul>
                  <li><a href="https://www.16personalities.com/br/teste-de-personalidade">Testes suas Habilidades Aqui</a></li>
              </ul>
          </div>
          
          <div>
              <div>
                  <form action="index.html" method="POST" onsubmit="true">
                      <fieldset>
                          <legend>Comente Sobre Suas Habilidades</legend>
                          <div>
                              <textarea name="comentarioSkill" id="idComentarioSkill" cols="252" rows="5" placeholder="Escreva aqui suas habilidades"></textarea>
                          </div>
                          <div>
                              <input type="submit" value="Salvar" />
                          </div>
                      </fieldset>

                  </form>
              </div>
          </div>

      <p>Clique<a href="principal.html">aqui</a> para voltar a página inicial.</p>

    </>

  )
}
