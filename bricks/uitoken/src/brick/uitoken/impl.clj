(ns brick.uitoken.impl)


(defonce tokens (atom {}))


(defn assoc-color
  [m key value theme]
  (if (some? theme)
    (assoc-in m [key theme] value)
    (assoc m key value)))

(defn- color-token
  [key value {:keys [theme variant] :or {variant :default}}]
  (let [old-value (get-in @tokens [:color key variant])]
    (cond
      (not (map? old-value))
      
      )
    )
  (if (some? theme)
    (swap! tokens assoc-in [:color key variant (keyword "theme" (name theme))] value)
    (swap! tokens assoc-in [:color key variant]))
  )

(defn deftoken
  [kind key value & args]
  (case kind
    :color (color-token key value args)))


(deftoken :color :primary "#FF0000")

(deftoken :color :primary "#FF0000" :theme :light)

(deftoken :color :primary "#FF0000" :theme :dark :variant 600)


{:color {:primary {:default "#FF0000"
                   600      {:theme/dark  "value"
                             :theme/light "value"}
                   500      "#FF0000"}}}


(update-in {} [:color :primary] assoc :default "#FF0000")



