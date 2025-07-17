(ns viska.app
  (:require
   ["electron/main" :refer [app BrowserWindow ipcMain]]
   ["path" :as path]))






(defn create-window 
  []
  (let [win (BrowserWindow.
              (clj->js {:width 800
                        :height 600
                        :webPreferences {:preload (.join path js/__dirname "../preload.js")}}))]
                        ;:webPreferences {:preload (.join path js/__dirname "../../../../ui/public/js/compiled/ui.js")}}))]
    (.loadFile win "../../..ui/public/index.html")
    ))

(defn topics-dir 
  []
  (.join path (.getPath app "userData") "topics"))


(defn setup-api-handlers [store]
  (.on ipcMain "chat/send-message"
       (fn [event request-id messages]
         (let [messages-clj (js->clj messages :keywordize-keys true)]
           (println :event event :reqest-id request-id :messages messages-clj)
           )))

  ;; NOTE: Electron IPC handlers must return values. We're abusing Nexus effects to return values
  ;; (not idiomatic) with nxr-result because I'd like to maintain FCIS architecture.
  (.handle ipcMain "topic/save"
          (fn [_event topic-data]
            (println [:event _event :data topic-data])))

  (.handle ipcMain "topic/load"
           (fn [_event]
             (println [:_event]))))


(defn ^:export main
  []
  (let [store (atom {})]
    (setup-api-handlers store)
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