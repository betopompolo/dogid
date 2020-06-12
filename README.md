# Dog Id

## Arquitetura
Este projeto utiliza a arquitetura MVVM. Os arquivos estão separados em duas camadas principais:
### UI
A camada `ui` contem as `activities`, `fragments` e `adapters`, além de um package `utils` contendo atualmente apenas uma classe para validação de dados (como e-mail)

### Data
Nesta camada estão os `datasources`, `repositórios` e os `modelos` utilizados no app. Os modelos utilizados nos `datasources` estão na pasta `datasource`.


Além disso, nessa camada há também `mappers` responsáveis por mapear modelos dos `datasources` para os modelos utilizados no app    

## Dependências
- [Retrofit](https://square.github.io/retrofit/) para requisições HTTP
- [Glide](https://bumptech.github.io/glide/) para download e cache de imagens
- [MockK](https://mockk.io/) para testes unitários
- Dependências do [Android Jetpack](https://developer.android.com/jetpack/arch/):
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) utilizado para auxiliar na implementação da arquitetura MVVM
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) utilizado para que a UI reaja a mudança dos dados, mais especificamente, os guardados nos ViewModels
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) possibilita que componentes, como o viewModel, reaja a eventos do ciclo de vida de componentes como activities e fragments
  - [Kotlin KTX](https://developer.android.com/kotlin/ktx) para um código mais conciso em Kotlin, além de auxiliar o gerenciamento dos viewModels (com as funções `by viewModels()` e `by activityViewModels()`)


## APK
A apk deste projeto pode ser encontrada [neste link](https://drive.google.com/file/d/1t_jksMirbL397sGiJ2gNQzfXx7qZN7Kh/view?usp=sharing)