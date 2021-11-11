graph = {
  '1' : ['2','3'],
  '2' : ['4', '5'],
  '3' : ['x'],
  '4' : [],
  '5' : ['x'],
  'x' : []
}
visited=[]

def dfs(root):
    if root not in visited:
        print(root)
        visited.append(root)
        for childs in graph[root]: #tesko euta euta childs lai lidai janxa visited ma hudai janxa
            dfs(childs)

if __name__=="__main__":
    dfs('2')