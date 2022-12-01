(ns day1
  (:require
    [clojure.java.io :as io]))


(def e (line-seq (io/reader (io/resource "example1.txt"))))
(def input (line-seq (io/reader (io/resource "input1.txt"))))


(defn add-calories
  [bunch]
  (reduce +  (map #(Integer/parseInt %) bunch)))


(defn find-max-cals
  [cals]
  (reduce (fn [highest bunch]
            (max highest (add-calories bunch))) 0 cals))


(defn find-part-1-answer
  [input]
  (->> input
       (partition-by empty?)
       (filter #(not-empty (first %)))
       (find-max-cals)))


(find-part-1-answer input)


;; => 71506
