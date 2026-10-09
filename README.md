# Simulador de Prefeito

## Descrição do projeto

O Simulador de Prefeito é um programa interativo desenvolvido em Kotlin que simula a administração de uma prefeitura durante um mandato de quatro anos.

O jogador define o imposto anual cobrado dos cidadãos e escolhe políticas públicas relacionadas à saúde, educação, economia, infraestrutura ou economia de recursos.

Cada decisão influencia o caixa da prefeitura e a aprovação popular. Dependendo dos resultados, o prefeito poderá concluir o mandato, conseguir a reeleição, sofrer impeachment ou enfrentar uma falência administrativa.

As regras financeiras e tributárias são fictícias e utilizadas para fins educacionais.

## Funcionalidades

- Definição do imposto anual.
- Escolha de políticas públicas durante quatro anos.
- Cálculo de arrecadação e despesas.
- Controle da aprovação popular.
- Verificação de impeachment e falência administrativa.
- Avaliação dos requisitos para reeleição.
- Validação das entradas digitadas pelo usuário.

## Conceitos de Kotlin utilizados

- Variáveis e tipos de dados.
- Operadores aritméticos, relacionais e lógicos.
- Estruturas condicionais `if/else` e `when`.
- Estruturas de repetição `for` e `while`.
- Funções.
- Null Safety com `?.` e `?:`.
- Entrada e saída pelo terminal.

## Como executar

1. Instale o IntelliJ IDEA e configure um JDK compatível com Kotlin.
2. Abra o projeto Prefeitura no IntelliJ IDEA.
3. Acesse `src/main/kotlin/Prefeitura.kt`.
4. Execute a função `main()`.
5. Digite o imposto anual desejado.
6. Escolha uma política pública em cada ano e acompanhe os resultados.

## Regras principais

- O mandato dura quatro anos.
- Impostos acima de R$ 2.000 causam impeachment imediato.
- Aprovação abaixo de 30% provoca impeachment.
- Dívida superior a R$ 500 milhões provoca falência administrativa.
- A reeleição exige aprovação mínima de 60% e caixa de pelo menos R$ 70 milhões.