# QA project template
- Project requirements:
1) Mac OS/Win 10
2) Java Development Kit 8
3) Google Chrome browser (latest version is recommended for local run)
4) Mozilla Firefox browser (latest version is recommended for local run)
5) Docker
6) Selenoid (See installation notes here: https://aerokube.com/selenoid/1.3.1/#_getting_started)
- Run project
1) Clone as a Maven project
- Run tests:
1) Make sure docker and selenoid are up and running.
2) Run "mvn clean test -Pbrowser-chrome-remote -Penv-dummy" in a command line in local project repository location. This command will run tests in docker.
- Generating Allure report
1) Install allure with following command "brew install allure" or check this doc for non-mac platforms: "https://docs.qameta.io/allure/"
2) Report can be generated only after test run
3) Run "allure serve" in a command line from project location