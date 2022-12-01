(ns day1
  (:require
    [clojure.java.io :as io]
    [clojure.string :as string]))


(defn parse-input-2
  [filename]
  (-> filename
      io/resource
      slurp
      (string/split #"\n\n")))


(defn parse-input
  [filename]
  (-> filename
      io/resource
      io/reader
      line-seq))


(parse-input-2 "example1.txt")

(def e (parse-input "example1.txt"))
(def input (parse-input "input1.txt"))


(defn filter-empty
  [input]
  (->> input
       (partition-by empty?)
       (filter #(not-empty (first %)))))


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
       filter-empty
       (find-max-cals)))


(find-part-1-answer input)


;; => 71506

(defn calculate-top
  [potential]
  (->> potential
       (sort >)
       (take 3)))


(defn find-top-cals
  [cals]
  (reduce (fn [top bunch]
            (calculate-top (concat top [(add-calories bunch)]))) [] cals))


(defn find-part-2-answer
  [input]
  (->> input
       filter-empty
       (find-top-cals)
       (reduce +)))


(find-part-2-answer input)


;; => 209603
