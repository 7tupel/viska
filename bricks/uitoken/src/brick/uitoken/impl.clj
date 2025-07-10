(ns brick.uitoken.impl)


(defonce tokens* (atom {}))


(defn assoc-token
  [m kind key value variant theme]
  (assoc-in m [kind key variant theme] value))


(defn- prefix-theme
  [k]
  (if (= (namespace k) :theme)
    k
    (keyword "theme" (name k))))

(comment
  (prefix-theme :theme/light) ; -> :theme/light
  (prefix-theme :dark) ; -> :theme/dark
  (prefix-theme "fail") ; -> throws
  )

(defn- color-token
  [key value {:keys [theme variant] :or {variant :default theme :theme/default}}]
  (swap! tokens* assoc-token :color key value variant (prefix-theme theme)))


(defn deftoken
  [kind key value & args]
  (case kind
    :color (color-token key value args))
  @tokens*)


(defn get-themed
  [])

(defn get-token
  ([kind key]
   (get-in @tokens [kind key :default])))