(ns brick.r2.next
  (:require
   [clojure.spec.alpha :as s]))





(defprotocol IDB
 (mutate-schema [this ]))


(deftype DB 
  [^{:volatile-mutable true} schema]
 
 )


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;; Schema Attribute Specs

;; The Name of the Attribute
;; must be a keyword.
(s/def :db.attribute/name keyword?)

;; The internal ID of the Attribute
(s/def :db.attribute/name pos-int?)

;; Uniqueness constraint of an Attribute
(s/def :db.attribute/unique #{:db.unique/identity :db.unique/value :db.unique/none})

;; Cardinality of an Attribute
(s/def :db.attribute/cardinality #{:db.cardinality/one :db.cardinality/many})

;; Value Type of the Attribute
(s/def :db.attribute/valueType #{:db.type/ref :db.type/value})

;; Scope of an Attribute
;; The Scope of an Attribute indicates if the Attribute is synced to a remote
(s/def :db.attribute/scope #{:db.scope/global :db.scope/local})

;; Docstring of an Attribute
(s/def :db.attribute/doc string?)




(defn add-watch-impl
  [sref key f]
  (set! (.-watches sref) (assoc (.-watches sref) key f)))

(defn remove-watch-impl
  [sref key]
  (set! (.-watches sref) (dissoc (.-watches sref) key)))

(defn get-watches-impl
  [sref]
  (.-watches sref))

(defn set-validator-impl
  [sref f]
  (set! (.-validator sref) f))

(defn get-validator-impl
  [sref]
  (.-validator sref))


(defprotocol ISchema
  (update-attribute [this attr kwargs])
  (add-attribute [this attr kwargs]))


(deftype Schema
  [^:volatile-mutable watches
   ^:volatile-mutable validator]
  ; clojure.lang.IDeref
  ; (deref [this] this)
  ; clojure.lang.IRef
  ; (addWatch [this key f] (add-watch-impl this key f))
  ; (removeWatch [this key] (remove-watch-impl this key))
  ; (getWatches [this] (get-watches-impl this))
  ; (setValidator [this f] (set-validator-impl this f))
  ; (getValidator [this] (get-validator-impl this))
  ; Object
  ; (toString [this] (pr-str this))
  ;ISchema
  clojure.lang.IGetter
  
  )


(defn init-schema
  []
  (Schema. {} nil))


; (defn add-attribute-impl
;   [schema attr {}])

(def foo (init-schema))


(add-watch foo :a (fn [] "hello"))

(get-validator foo)


(.watches foo)

foo

(str foo)


(deftype Unicorn [^:volatile-mutable name])


(def u (Unicorn. "Hans"))



(.-name u)

;;https://ask.clojure.org/index.php/12491/volatile-mutable-recognized-some-deftype-method-subforms