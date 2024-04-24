Repositório dedicado para atividade de engenharia de software 2024/1

# Principios-SOLID
Irão ser tradados sobre os seguintes conceitos aqui:

  S — Single Responsiblity Principle (Princípio da responsabilidade única)
  O — Open-Closed Principle (Princípio Aberto-Fechado)
  L — Liskov Substitution Principle (Princípio da substituição de Liskov)
  Prefira Composição a Herança


# Single Responsiblity Principle (Princípio da responsabilidade única)
Uma classe deve ter apenas uma responsabilidade, isso significa que uma classe deve ter apenas uma tarefa ou função específica e deve ser a única responsável por executá-la. Isso ajuda a garantir que o código seja mais coeso, fácil de entender, manter e reutilizar. Caso contrario a classe tende se torna mais difícil de manter pois a código confuso, propenso a erros e difícil de testar. 


# Open-Closed Principle (Princípio Aberto-Fechado)
Classes, módulos, funções, etc.Devem ser abertas para extensão, mas fechadas para modificação. Isso significa que uma classe deve ser facilmente estendida para adicionar novos comportamentos sem modificar o código existente.

# Liskov Substitution Principle (Princípio da substituição de Liskov)
Uma classe derivada deve poder ser substituída pelos objetos da classe base sem afetar a correção do programa. Em outras palavras, se S é um subtipo de T, então os objetos do tipo T podem ser substituídos por objetos do tipo S sem alterar a funcionalidade do programa.
Essa substituição é importante porque permite que o código seja mais flexível e modular, facilitando a manutenção e a extensão do sistema. Ao seguir o LSP, os desenvolvedores podem criar hierarquias de classes mais coesas e menos propensas a erros.


# Prefira Composição a Herança
Utiliza-se a herança se uma instância de uma classe Filha nunca precisar tornar-se um objeto de outra classe, se a hierarquia de herança representar um relacionamento "É um" e não um relacionamento "Tem um", se deseja-se ou precisa-se realizar alterações globais para as suas classes filhas alterando uma classe Pai, ou então quando a classe filha estender ao invés de substituir total ou parcialmente as responsabilidades da classe Pai. Caso contrario utilize composição. 