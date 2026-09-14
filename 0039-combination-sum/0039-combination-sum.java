class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> list,int[] candidates,int remain,int start){
        if(remain==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>remain){
                break;
            }
            list.add(candidates[i]);
            backtrack(res,list,candidates,remain-candidates[i],i);
            list.remove(list.size()-1);
        }
    
    }
}