# SwaggerCodeGenProject


Frequest changes into swagger files and definitions of model can cause an issues in pojo, and most of the time automation engineer spends it time fixing pojos or creating pojos manually. To overcome this issue swagger provides codegen plugin it helps to create pojos from models available in yaml file.


Process
1. Add swagger code gen plugin dependancy
2. Add swagger file in resources ( in future we can make a change so that our function can download swagger files from hoste server locations)
3. Follow maven lifecycle mvn clean and mvn compile will create models in Target folder (never commit Target folder into repo)
