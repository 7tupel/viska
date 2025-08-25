(ns development
  (:require
   [clojure.string :as str]
   [manifold.stream :as s]
   [aleph.http :as http]
   [aleph.udp :as udp]))


(def rest-server-port 9234)

(def ssdp-port 1900)

(def ssdp-link-local-address
  "ff02::c")

(def client-socket @(udp/socket {}))

(defn send-ssdp-message
  []
  (s/put! client-socket
    {:host ssdp-link-local-address
     :port ssdp-port}))