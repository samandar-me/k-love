package com.sdk.klove

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory

/*
class RootComponent internal constructor(
    componentContext: ComponentContext,
    private val main: (ComponentContext, (MainComponent.Output) -> Unit) -> MainComponent,
    private val finger: (ComponentContext, (FingerComponent.Output) -> Unit) -> FingerComponent,
    private val image: (ComponentContext, (ImageComponent.Output) -> Unit) -> ImageComponent,
    private val text: (ComponentContext, (TextComponent.Output) -> Unit) -> TextComponent
): ComponentContext by componentContext {
    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory
    ): this(
        componentContext = componentContext,
        main = { childContext, output ->
            
        },
        finger = { childContext, output ->
            
        },
        image = { childContext, output ->

        },
        text = { childContext, output ->

        }
    )
    private val navigation = StackNavigation<Configuration>()
    private val stack = childStack(
        source = navigation,
        initialConfiguration = Configuration.Main,
        handleBackButton = true,
        childFactory = ::createChild
    )
    val childStack: Value<ChildStack<*, Child> = stack
    
    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child =
        when(configuration) {
            is Configuration.Main -> Child.Main(main(componentContext, ::onMainOutput))
            is Configuration.Text -> Child.Text(text(componentContext, ::onTextOutput))
            is Configuration.Image -> Child.Text(image(componentContext, ::onImageOutput))
            is Configuration.Finger -> Child.Text(finger(componentContext, ::onFingerOutput))
        }
    
    private fun onMainOutput(output: MainComponent.Output) = when(output) {
        is MainComponent.Output.OnButtonClicked -> {
            
        }
    }
    
    private sealed interface Configuration: Parcelable {
        @Parcelize
        data object Main: Configuration
        @Parcelize
        data object Finger: Configuration
        @Parcelize
        data object Image: Configuration
        @Parcelize
        data object Text: Configuration
    }
    sealed class Child {
        data class Main(val component: MainComponent): Child()
        data class Finger(val component: FingerComponent): Child()
        data class Image(val component: ImageComponent): Child()
        data class Text(val component: TextComponent): Child()
    }
}

*/