# Simulador TCP e UDP - etapa 1

Base inicial para o Trabalho Prático 2 de Redes Convergentes. Esta etapa prepara o projeto Maven e abre uma janela JavaFX. A simulação dos protocolos, as FSMs e os dez cenários de teste ainda serão construídos nas próximas etapas.

## Tecnologias

| Tecnologia | Função |
| --- | --- |
| Java 17 ou superior | Linguagem e runtime. É possível manter o JDK 25. |
| Maven | Dependências, compilação e execução. |
| JavaFX 21.0.6 | Interface desktop. |
| JUnit Jupiter 5.11.4 | Testes futuros do núcleo, sem abrir a interface. |

O `maven.compiler.release` está em 17 para produzir bytecode compatível com Java 17 ou superior. Isso não exige instalar um JDK mais antigo se você já utiliza o JDK 25. As versões das dependências estão fixadas para manter a configuração reproduzível.

## Primeiro passo

1. Extraia o ZIP.
2. Abra a pasta `simulador-transporte-etapa-1` no IntelliJ IDEA ou no VS Code.
3. No IntelliJ, importe o projeto como Maven e configure o SDK do projeto e o JDK do Maven para o seu JDK instalado. No VS Code, utilize a extensão Extension Pack for Java.
4. No terminal dessa pasta, confira o ambiente:

```powershell
java -version
mvn -version
```

5. Compile e abra a janela:

```powershell
mvn clean compile
mvn javafx:run
```

Na primeira execução, o Maven precisa de internet para baixar as dependências. Não é necessário baixar o SDK do JavaFX separadamente.

O resultado esperado é uma janela com o título "Simulador da camada de transporte", a mensagem "Etapa 1: janela inicial pronta" e um botão "Fechar" funcional. Para executar pelo IntelliJ, também é possível usar a janela Maven, em Plugins > javafx > javafx:run.

## Entenda os arquivos desta etapa

| Arquivo | Responsabilidade |
| --- | --- |
| `pom.xml` | Configura Java, JavaFX, JUnit e os plugins Maven. |
| `src/main/java/br/com/jvcid/transporte/simulation/Launcher.java` | Contém o método `main` e inicia o runtime do JavaFX. |
| `src/main/java/br/com/jvcid/transporte/ui/SimulatorApplication.java` | Cria a janela e seus componentes visuais. |
| `src/main/resources/styles/app.css` | Define cores, fontes e espaçamento. |

No método `start`, `Stage` representa a janela, `Scene` é seu conteúdo e `VBox` organiza os controles verticalmente. `stage.show()` torna a janela visível. Essas classes ficam na interface; as regras dos protocolos serão implementadas em classes sem imports de JavaFX.

## Arquitetura que vamos construir

Todos os pacotes abaixo ficarão sob `br.com.jvcid.transporte`. Apenas `app` e `ui` existem nesta etapa.

| Pacote planejado | Responsabilidade |
| --- | --- |
| `app` | Inicialização da aplicação. |
| `ui` | Diagramas de estados e de sequência, controles, painel do canal e tabela de logs. |
| `simulation` | Relógio virtual, fila de eventos, execução e pausa da simulação. |
| `fsm` | Carregamento das definições JSON, validação de eventos e execução das transições. |
| `channel` | Perda, atraso, corrupção, duplicação, reordenação e descarte manual. |
| `protocol.udp` | Datagramas, checksum em complemento de 1 de 16 bits e entrega à aplicação. |
| `protocol.tcp` | Estados da conexão, sequência, ACK cumulativo, RTT e retransmissões. |
| `logging` | Eventos e métricas compartilhados entre testes e interface. |

As definições das FSMs ficarão em `src/main/resources/fsm/`. Os testes ficarão em `src/test/java/`. A interface observará os eventos do núcleo; o núcleo funcionará sem a interface.

O canal será simulado em memória. Isso permite reproduzir perdas e atrasos usando uma seed e avançar o tempo virtual sem depender do tempo real.

## Ordem das próximas etapas

1. Relógio virtual e fila determinística de eventos.
2. Motor genérico de FSM com definições JSON e registro de eventos inválidos.
3. Canal em memória com falhas e seed configurável.
4. UDP: estado único, datagramas e checksum real.
5. TCP: todos os estados, handshake, encerramento normal e simultâneo, RST e TIME_WAIT.
6. TCP: transferência confiável, ACK cumulativo, estimativa de RTT, timeout e retransmissão rápida.
7. Os dez cenários automatizados exigidos, escritos e verificados ao longo da implementação.
8. Interface completa conectada ao núcleo e comparação UDP x TCP.
9. Relatório de 4 a 6 páginas e demonstração de até 5 minutos com os resultados reais.

## Critérios de conclusão do trabalho

- Definições das FSMs dirigidas por dados; não substituir o motor por regras de estado espalhadas pela interface.
- Simulação reproduzível com seed e relógio virtual.
- Dez cenários automatizados, com relatório aprovado/reprovado.
- Capturas reais da GUI nos cenários 3, 5 e 6.
- Comparação quantitativa do cenário 10 e respostas às quatro perguntas do relatório.
- README atualizado e código versionado em Git.

Para iniciar o versionamento no seu computador, depois de conferir esta etapa:

```powershell
git init
git add .
git commit -m "chore: configura projeto Maven e janela JavaFX"
```

## Referências de configuração

- [JavaFX com Maven](https://openjfx.io/openjfx-docs/maven)
- [Requisitos do JavaFX 21](https://github.com/openjdk/jfx/blob/jfx21/doc-files/release-notes-21.md)
- [JUnit 5.11.4](https://docs.junit.org/5.11.4/user-guide/index.html)

## Validação desta base

A compilação com `mvn clean compile` foi concluída com sucesso usando OpenJDK 17 e Maven 3.9.9. A interface não foi executada neste ambiente sem tela; confira sua abertura no seu computador seguindo o primeiro passo. Ainda não existem testes dos protocolos nesta etapa.
