(ns util
  (:require
    [clojure.java.io :as io]
    [clojure.string :as string]))


(defn parse-input
  [filename]
  (-> filename
      io/resource
      slurp
      (string/split #"\n")))
