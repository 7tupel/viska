(ns viska.app
  (:require
   ["electron/main" :refer [app BrowserWindow ipcMain]]
   ["path" :as path]))






(defn create-window 
  []
  (let [win (BrowserWindow.
              (clj->js {:width 800
                        :height 600
                        :webPreferences {:preload (.join path js/__dirname "../app/public/js/main.js")}}))]
    (.loadFile win "../app/public/index.html")))




(defn ^:export main
  []
  (println "Hello World from App!")
  (let [store (atom {})]
   ; (setup-api-handlers store)
    (-> (.whenReady app)
        (.then (fn []
                 (create-window)
                 ;(menu/create-menu store)
                 (.on app "activate"
                      #(when (zero? (.-length (.getAllWindows BrowserWindow)))
                         (create-window))))))

    (.on app "window-all-closed"
        #(when-not (= (.-platform js/process) "darwin")
            (.quit app)))))