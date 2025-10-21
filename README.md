Integrantes:
Pablo Canavarro de Sá
Otávio de Araujo Chaves Neto
Lucas Emmanuel Silva Luz

Descrição:
O sistema permite cadastrar, remover, buscar e ordenar estudantes, além de registrar informações das matrículas com dados dos respectivos estudantes.

As principais funcionalidades implementadas foram:

#Cadastrar, buscar, remover e ordenar estudantes.

#Cadastrar disciplinas sem permitir duplicação.

#Registrar as notas dos estudantes em cada disciplina.

#Calcular médias individuais e por disciplina.

#Exibir relatórios de desempenho, como:

  Lista de alunos com média acima de 8.0.

  Disciplinas com média abaixo de 6.0.

  Ranking dos três melhores alunos.

Justificativa:
#A classe ListaDeEstudantes utiliza um ArrayList para armazenar objetos da classe Estudante, visto que o ArrayList é muito útil quando é necessário o acesso rápido por índice e a quantidade de elementos é variável.

#Foi utilizado LIST por:
   É necessário preservar a ordem de inserção dos estudantes.

   Permite acessar elementos por índice, ordenar e percorrer sequencialmente.

   É possível ordenar alfabeticamente com o método Collections.sort() e um Comparator.

#Foi utilizado SET por:
   Um Set não permite duplicatas, o que reflete a regra de que duas disciplinas não podem ter o mesmo código.

   O LinkedHashSet mantém a ordem de inserção, útil para exibir as disciplinas na mesma sequência em que foram cadastradas.

#foi utilizado MAP por:
  A chave (Integer) representa o ID do estudante.

  O valor é uma lista com todas as matrículas (disciplinas e notas) desse estudante.

Como executar o programa:
O método consiste em alterar as funções na classe Main, visto que os dados são hardcoded

Desafios:
Os principais desafios foram a implementação dos construtores no código e a ordenação dos dados
