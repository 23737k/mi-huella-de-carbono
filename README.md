### Ejecución de la Aplicación de Consola

```markdown
mvn compile exec:java -Dexec.mainClass="my_app.Mi_Huella.App" -Dexec.args="-m src/main/resources/mediciones.csv -p src/main/resources/parametros.csv"

