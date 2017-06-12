# BioInformatics
## Introdução
Em bioinformatica , um alinhamento de sequencias é uma maneira de organizar sequencias de DNA, RNA ou proteínas para a identificação de sequencias semelhantes.
As sequências possuem aminoácidos ou nucleotídeos e o seu alinhamento pode ser representado em linhas e colunas dentro de uma matriz. 
Se duas sequências de um alinhamento compartilham um antepassado comum, as imperfeições podem ser interpretadas como uma mutação.
As abordagens computacionais para o alinhamento de sequências são divididas em geral em duas categorias: alinhamentos globais e alinhamentos locais. O alinhamento global é uma solução para forçar o alinhamento entre todo o comprimento de uma sequencia. O alinhamento Local identifica regiões de similaridade em sequências mais pequenas que geralmente são bastante diferentes.
Existe uma grande variedade de algoritmos para abordar o problema de alinhamento de sequências, os mais conhecidos são baseado em programação dinâmica (DP) com base em heurísticas.

## Objetivos do trabalho
Este trabalho foi desenvolvido no ambito da cadeira de BioInformatica com os seguintes objectivos:

  * Selecione uma bactéria e um eucarionte para os quais o genoma foi sequenciado.
  * Compute os totais de nucleotideos no genome e no material codificador.
  * Contar os numero de transições.
  * Implementação de Algoritmo de Programação Dinâmica para o alinhamento Global.
  
## Implementação 
A Classe Reader.java , reponsavel pelo parsing/leitura do ficheiro que contem as sequencias DNA de um ficheiro retirado do Protein Data Bank.
A Classe Count.java responsavel pela contagem de nucleotideos, tanto conta as bases de DNA como RNA, como tal a função responsavel pela contagens são: 

  * count_bases_DNA(String[] bases, String[] sequence)
  * count_bases_RNA(String[] bases, String[] sequence)
  
Ambas só necessitam da sequencia a analizar e as bases para cada uma das sequencias.
De seguida e seguindo a estrutura dos tópicos proposto para o trabalho foi implementada a Classe Transitions.java que é responsável pela criação e preenchimento de uma matriz de transiçoes, a função responsavel é :
 
 * fill_Matrix(String[] sequence, String[] sequence2)
 
Só precisa que lhe forneçam duas sequencias para poder calcular o numero de transições entre elas.
Esta classe seria também responsável pela estimação de probabilidades mas fomos incapazes até o momento de implementar a solução.
Para implementação do alinhamento Global foi criada a classe NeedlemanWunsch.java juntamente com as classes AlignmentResult.java e SimpleAlignmentParameters.java que servem como suporte para a implementação deste algoritmo.
No algoritmo é de notar as seguintes funções:
  * dumpMatrix(int[][] matrix,String row,String column)
  * computeNWAlignment(String seq1,String seq2,SimpleAlignmentParameters parameters)
Todas estas classes são controladas pela classe Main.java que é a responsável por lançar todos estes métodos, é de notar nesta classe a seguinte função:

* testNWAlignment(String seq1, String seq2)

Que é uma função responsável pela chamada e resultado do algoritmo de Needleman-Wusch, para testar só será necessário algo deste género **testNWAlignment("TATATCGC", "ATCATAT")**.Para o resto dos resultados só é necessário ter os ficheiros no diretório do projeto, e compilar todas as classes e correr a classe Main.

Para qualquer comentario ou questão contactar andre.j.fonseca@gmail.com ou up201006344@fc.up.pt 
