import UIKit
import shared // ✅ importa o framework gerado pelo módulo shared

@main
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?

    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        // Cria a janela principal
        let window = UIWindow(frame: UIScreen.main.bounds)

        // Define o rootViewController como o Compose Multiplatform
        window.rootViewController = MainViewController() // ✅ chama a função do shared

        self.window = window
        window.makeKeyAndVisible()
        return true
    }
}
