(ns day2
  (:require
    [clojure.string :as string]
    [util]))


(defn parse
  [filename]
  (->> filename
       util/parse-input
       (map #(map keyword (string/split % #" ")))))


(def example (parse "example2.txt"))
(def input (parse "input2.txt"))


(def winning-guide
  {:rock     :scissors
   :paper    :rock
   :scissors :paper})


(defn rps
  [[them you]]
  (cond
    (= them you)                 :tie
    (= them (you winning-guide)) :win
    :else                        :loss))


(def col1
  {:A :rock
   :B :paper
   :C :scissors})


(def col2
  {:X :rock
   :Y :paper
   :Z :scissors})


(defn tranform-col
  [[them you]]
  [(them col1) (you col2)])


(defn input-rps
  [input]
  (rps (tranform-col input)))


(def play-points
  {:win  6
   :tie  3
   :loss 0})


(def shape-points
  {:X 1
   :Y 2
   :Z 3})


(defn find-col-points
  [input]
  (+ ((last input) shape-points)
     ((input-rps input) play-points)))


(def part1
  (->> input
       (map find-col-points)
       (apply +)))


;; => 12156

(def part2-col2
  {:X :loss
   :Y :tie
   :Z :win})


(def shape-points-2
  {:rock     1
   :paper    2
   :scissors 3})


(defn find-shape
  [[them outcome]]
  (cond (= :Y outcome) (them col1)
        (= :X outcome) ((them col1) winning-guide)
        :else ((them col1) (zipmap (vals winning-guide) (keys winning-guide)))))


(defn part-2-points
  [input]
  (+ (((last input) part2-col2) play-points)
     ((find-shape input) shape-points-2)))


(->> input
     (map part-2-points)
     (apply +))


;; => 10835
