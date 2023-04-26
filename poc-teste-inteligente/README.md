necessario gerar a pasta target:

    mvn clean package

comando para executar o evosuite:

    docker run -it -u $(id -u):$(id -g) -v $(pwd):/evosuite -v $(pwd)/src/test/java/poc/teste/inteligente/evosuite:/evosuite/project/evosuite-tests evosuite/evosuite:1.2.0-java-8 -generateSuite -class poc.teste.inteligente.ValidadorDeBilhetes -projectCP target/classes -base_dir /evosuite/project/evosuite-tests