Projetos LCQS - SGQ API

Este repositório centraliza o desenvolvimento de ferramentas de automação e gestão para o **Laboratório de Controle de Qualidade em Saúde (LCQS)**. O foco principal é a **SGQ-API**, uma interface de programação voltada para o Sistema de Gestão da Qualidade.

Sobre o Projeto
O projeto visa modernizar o fluxo de dados do laboratório, substituindo processos manuais por uma estrutura robusta de API, garantindo integridade e rastreabilidade nas análises de alimentos e produtos de saúde.

Stack Técnica
- **Linguagem:** Java
- **Framework de Persistência:** JPA / Hibernate (Java Persistence API)
- **Banco de Dados:** MySQL
- **Ambiente:** VS Code com extensões Java e Debugger

Estrutura da API
A API foi desenhada para gerenciar as entidades principais do laboratório, incluindo:
- Controle de Amostras.
- Gerenciamento de Laudos Técnicos.
- Rastreabilidade de Analistas e Equipamentos.

Organização
- `sgq-api/`: Código-fonte da aplicação e lógica de negócio.
- `.vscode/`: Configurações de ambiente de desenvolvimento.
- `Comandos.txt`: Guia rápido de comandos e referências para manutenção do sistema.
Requisitos de Instalação
1. Configurar o banco de dados MySQL conforme as entidades JPA.
2. Certificar-se de que o Java JDK 17+ está instalado.
3. Configurar as credenciais do banco no arquivo de propriedades da aplicação.
